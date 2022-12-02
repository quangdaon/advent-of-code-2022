require 'src/processor'
require 'test/unit'

class TestProcessor < Test::Unit::TestCase
  def test_parse_batch__given_single_group__returns_array
    processor = Processor.new
    batch = processor.parse_batch("1")

    assert_equal([1], batch)
  end

  def test_parse_batch__given_multi_group__returns_array
    input = %{
      1
      2
      3
    }

    processor = Processor.new
    batch = processor.parse_batch(input)

    assert_equal([1, 2, 3], batch)
  end

  def test_create_batches__given_single_batches__returns_single_item_arrays
    input = %{
      1

      2

      3
    }

    processor = Processor.new
    batches = processor.create_batches(input)

    assert_equal([[1], [2], [3]], batches)
  end

  def test_create_batches__given_multi_batches__returns_arrays
    input = %{
      1
      5
      
      2
      78
    }

    processor = Processor.new
    batches = processor.create_batches(input)

    assert_equal([[1, 5], [2, 78]], batches)
  end

  def test_sum_batches__given_batches__returns_summed_batches
    batches = [[1,2], [5], [45, 55]]

    processor = Processor.new
    sums = processor.sum_batches(batches)

    assert_equal([3, 5, 100], sums)
  end

  def test_sum_x_highest__given_presorted_array__returns_correct_sum
    input = [7, 4, 3, 2, 1]
    
    processor = Processor.new
    result = processor.sum_x_highest(input, 3)

    assert_equal(14, result)
  end

  def test_sum_x_highest__given_shuffled_array__returns_correct_sum
    input = [1, 3, 7, 4, 2]
    
    processor = Processor.new
    result = processor.sum_x_highest(input, 3)

    assert_equal(14, result)
  end

  def test_process_part_1_solution__given_aoc_sample__returns_provided_result
    sample_input_file = File.open('inputs/input.sample.txt')
    sample_input_txt = sample_input_file.read
    
    processor = Processor.new
    result = processor.process_part_1_solution(sample_input_txt)

    assert_equal(24000, result)
  end

  def test_process_part_2_solution__given_aoc_sample__returns_provided_result
    sample_input_file = File.open('inputs/input.sample.txt')
    sample_input_txt = sample_input_file.read
    
    processor = Processor.new
    result = processor.process_part_2_solution(sample_input_txt)

    assert_equal(45000, result)
  end
end